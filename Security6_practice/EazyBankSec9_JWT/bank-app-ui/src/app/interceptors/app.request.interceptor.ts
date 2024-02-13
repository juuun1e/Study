import { Injectable } from '@angular/core';
import { HttpInterceptor,HttpRequest,HttpHandler,HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {tap} from 'rxjs/operators';
import { User } from 'src/app/model/user.model';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  user = new User();
  constructor(private router: Router) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let httpHeaders = new HttpHeaders();
    if(sessionStorage.getItem('userdetails')){
      this.user = JSON.parse(sessionStorage.getItem('userdetails')!);
    }
    
    //비밀번호가 null이 아닌 로그인 과정 중에 if 블록 속에 id 비밀번호를 Authorization에더의 일부로 보냄
    if(this.user && this.user.password && this.user.email){ // 해당 값을 basic으로 보내고 id와 비밀번호의 Basic64형식으로 보냄
      httpHeaders = httpHeaders.append('Authorization', 'Basic ' + window.btoa(this.user.email + ':' + this.user.password));
    }else {
      // sessionStorage에 저장된 JWT토큰을 읽어옴
      let authorization = sessionStorage.getItem('Authorization');
      if(authorization){ // null이 아니라면 sessionStorage에 저장된 JWT토큰과 값은 값을 요청 헤더의 일부로 보내게 됨. ()헤더 이름이 Authorization)
        httpHeaders = httpHeaders.append('Authorization', authorization);
      }
    }
    let xsrf = sessionStorage.getItem('XSRF-TOKEN');
    if(xsrf){
      httpHeaders = httpHeaders.append('X-XSRF-TOKEN', xsrf);
    }
    httpHeaders = httpHeaders.append('X-Requested-With', 'XMLHttpRequest');
    const xhr = req.clone({
      headers: httpHeaders
    });
  return next.handle(xhr).pipe(tap(
      (err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status !== 401) {
            return;
          }
          this.router.navigate(['dashboard']);
        }
      }));
  }
}
