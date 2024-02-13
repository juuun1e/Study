package com.eazybytes.constants;

public interface SecurityConstants {

    //백엔드 애플리케이션만 알고 있을 비밀 키의 값 - 지금은 직접적으로 언급하고 있지만 이상적으로는 배포시간에 DevOps팀에게 요청하여 값을 주입해야 함
    //(github나jenkins와 같은 CI/cd도구를 사용하여 환경변수로 설정하거나 프러덕션 서버 내에서 이를 환경변수로 구성할 수도 있음)
    // JWTTokenGeneratorFilter에서 Keys.hmacShaKeyFor()를 사용해 key를 생성하려고 함
    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    public static final String JWT_HEADER = "Authorization"; //헤더의 이름은 Authorization [권한 부여]
    // 동일한 헤더 이름을 -> Config파일의 setExposedHeaders() 안에 구성하여 브라우저가 이 헤더값을 수락하도록 해야 함.

}
