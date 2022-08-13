# 2022 MediPet </br>

## 반려동물을 위한 약 정보, 동물병원 정보를 제공하는 시스템 
### A system that provides drug information and animal hospital information for companion animals </br>

```
Project Nickname : 메디펫
Project execution period : 2022-08-09 ~
```

### Description
메디펫은 반려동물의 상태정보를 기록하고, 약 지식과 주변 동물병원 정보를 제공합니다. </br>



### 1. 기능 테이블

| num 	| Method 	|   URI  	| Description 	| server reflection 	| complete or not 	| note 	|
|:---:	|:------:	|:------:	|:-----------:	|:-----------------:	|-----------------	|------	|
|  1  	|   POST  	| /users 	|  회원가입 API |                   	|                 	|      	|
|  2   	|   GET   	| /users/:userIdx/auto_login |자동 로그인 API             	|                   	|                 	|      	|
|  3   	|   POST    | /users/login/kakao    	|카카오 로그인 API             	|                   	|                 	|      	|
|  4   	|   POST    |/users/login/google      |구글 로그인 API             	|                   	|                 	|      	|
|  5   	|   GET	    | /users/:userIdx         |유저 정보 조회 API                   	|                 	|      	|
|  6   	|   PATCH   |/users/:userIdx       	  |유저 정보 수정 API        	|                   	|                 	|      	|
|  7   	|   GET     |/hospitals?latitude=□□□&longitude=□□□&count=5        	|     메인화면 API        	|                   	|                 	|      	|
|  8   	|   GET     | /search?input=□□□       	|  약 or 병원 전체 검색 API           	|                   	|                 	|      	|
|  9   	|   GET     | /hospitals?latitude=□□□&longitude=□□□       	|사용자 근처 병원 조회 API             	|                   	|                 	|      	|
| 10   	|   GET     |  /hospitals/:hospitalIdx      	| 병원 상세 조회 API            	|                   	|                 	|      	|
| 11   	|   GET     | /medicines       	| 약 전체 조회 API (카테고리별)            	|                   	|                 	|      	|
| 12   	|   GET     |  /medicines/:medicineIdx      	|  약 상세 조회 API           	|                   	|                 	|      	|
| 13   	|   GET     |  /medicines/search?input=□□□      	|  약 검색 API           	|                   	|                 	|      	|
| 14    |   GET     |/medicines/medicinecategorys/:medicinecategoryIdx|약 카테고리 상세 조회 API
