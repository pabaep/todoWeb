# TODOWEB (웹에서 쉽게 관리하는 할 일 목록)
* 팀원 구성 : 
  - 🐈 황세원 ( 회원가입, 로그인 )
  - 🐣 김민기 ( 할 일 목록, 할일 작성)
  - 🐹 이승현 ( 할 일 작성 )

* 서비스 소개 : 언제나 로그인만 하면 확인 가능한 Todo List

* 프로젝트 기간 : 22/02/10 ~ 22/02/11

* 핵심 기능 : 
  1. 😀회원가입/로그인 - 이메일만 있으면 가입이 가능하고, 이를 이용하여 로그인 해 서비스를 이용할 수 있음
  2. 🧾할일 목록 - 작성한 할일 목록을 보여주고, 완료(삭제) 처리 할 수 있음
  3. 📝할일 작성 - 해야할 일의 이름, 시작 시간, 마감 시간을 지정하여 할일을 추가 할 수 있음

* 동작 구조 📊
![image](https://user-images.githubusercontent.com/55613591/153544284-d6aafce2-6806-4f8d-b7da-2f01b4568ba5.png)

* 실행화면 🖥

 <로그인 화면>
  
![image](https://user-images.githubusercontent.com/55613591/153544367-88377b68-1d8a-4b6c-a552-cd3830744cbc.png)

 <회원 가입>
 
![image](https://user-images.githubusercontent.com/55613591/153544511-d31cefc2-6d90-4c1d-b1dc-702b6697a469.png)

 <할 일 목록>

![image](https://user-images.githubusercontent.com/55613591/153544561-0915844b-fe01-4ab6-8cc8-1f45f6942c13.png)

 <할 일 작성>
 
![image](https://user-images.githubusercontent.com/55613591/153544581-d1eafb4d-a219-4208-b96f-9fc8f72b45dd.png)

* 트러블 슈팅
  - 할 일 테이블에 DATE 타입이 들어 가는 부분에서 초기 SQL 문장은 다음과 같이 작성했었다. <br>
      -> insert into  todoT values(seq_todo_id.NEXTVAL, ?, ?, ?, ?) <br>
        수정 이후 SQL 문장은 다음과 같다. <br>
      -> insert into  todoT values(seq_todo_id.NEXTVAL, ?, to_date(?,'YYYY-MM-DD HH24:MI'), to_date(?,'YYYY-MM-DD HH24:MI'), ?) <br>
  - DATE 타입에 대한 이해 부족으로 꽤나 수정하는데 시간을 많이 썼던 문제였다. <br> 이후에는 같은 실수를 반복하지 않기 위해 노력할 것이다.

* 개선할 사항
  - 회원 정보 관리( 회원 탈퇴, 비밀번호 수정 등 )
  - 유저 정보를 계속 가지고 진행하지 못함
  - 로그아웃 코드 개선(뒤로가기를 막는 다던지 등등)
  - 할 일 정보 수정
  - 할 일 완료 목록 관리
  - 시작시간과 마감시간을 기준으로 잔여 시간 표시
  - 잔여 시간이 일정 시간 보다 적을 경우 알림 보내기
  - 마감일자와 시작일자 논리적 에러 방지용 코드 작성
  - 유효한 이메일 여부 확인, 비밀번호 
