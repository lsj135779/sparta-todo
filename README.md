# sparta-todo
내일배움캠프 개인과제 todo앱 만들기

<details>
  <summary>숙련주차 개인과제</summary>

- [ ]  **🆕 회원 가입 API**
    - **API 가 사용될 화면 보기**
      
       <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2F80111660-613a-4ce7-bdd6-49975561e40a%2FUntitled.png?table=block&id=762867b9-53ca-4ecb-90b0-b73ed1063ecd&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=770&userId=&cache=v2" width="200" height="400">
        
    - username, password를 Client에서 전달받기
    - username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성되어야 한다.
    - password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성되어야 한다.
    - DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환하기
    - 참고자료
        1. https://mangkyu.tistory.com/174
        2. [https://ko.wikipedia.org/wiki/정규_표현식](https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D)
        3. https://bamdule.tistory.com/35
            
            
- [ ]  **🆕 로그인 API**
    - **API 가 사용될 화면 보기**

      <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2F5f20f99c-5203-4afb-87c3-d9cb96215840%2FUntitled.png?table=block&id=f0dc172c-2bb5-4c5f-92b7-eefebb9cef54&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=1670&userId=&cache=v2" width="500" height="200">

    - username, password를 Client에서 전달받기
    - DB에서 username을 사용하여 저장된 회원의 유무를 확인하고 있다면 password 비교하기
    - 로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급하고, 
    발급한 토큰을 Header에 추가하고 성공했다는 메시지, 상태코드 와 함께 Client에 반환하기
- [ ]  **게시글 할일카드 작성 기능 API**
    - **API 가 사용될 화면 보기**
        
        <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2Fd163fef3-2962-4762-9a76-bcd247b4f852%2FUntitled.png?table=block&id=69505f49-3332-4e49-afef-b6605b3093e5&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=580&userId=&cache=v2" width="200" height="400">
        
    - 토큰을 검사하여, 유효한 토큰일 경우에만 할일 작성 가능
    - `할일 제목`,`할일 내용`, `작성일`을 저장할 수 있습니다. (작성자명, 비밀번호)
    - 할일 제목, 할일 내용을 저장하고
    - 저장된 할일을 Client 로 반환하기(username은 로그인 된 사용자)
- [ ]  **선택한 게시글 할일카드  조회 기능 API**
    - **API 가 사용될 화면 보기**
        
        <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2F9f9ae771-6751-402a-add3-3249e998c704%2FUntitled.png?table=block&id=107ac418-842f-4385-8197-f3e427cf2645&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=2000&userId=&cache=v2" width="600" height="200">
        
    - 선택한 게시글 할일 의 정보를 조회할 수 있습니다.
        - 반환 받은 할일 정보에는 `할일 제목`,`할일 내용`, `작성자` , `작성일`정보가 들어있습니다.
        - 반환 받은 게시글의 정보에 비밀번호는 제외 되어있습니다.
- [ ]  **게시글 할일카드 목록 조회 기능 API**
    - **API 가 사용될 화면 보기**
        
        <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2Fdd72b3c7-39d4-4018-b04e-a9fb403028f7%2FUntitled.png?table=block&id=daa56c40-a060-44b9-a8fd-e5538bc36f34&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=1690&userId=&cache=v2" width="600" height="200">
        
    - 등록된 할일 전체를 조회할 수 있습니다.
        - 회원별로 각각 나누어서 할일 목록이 조회됩니다.
        - 반환 받은 할일 정보에는 `할일 제목`, `작성자` , `작성일`, `완료 여부`정보가 들어있습니다.
        - 반환 받은 할일 정보에 비밀번호는 제외 되어있습니다.
    - 조회된 할일 목록은 `작성일` 기준 내림차순으로 정렬 되어있습니다.
- [ ]  **선택한 게시글 할일카드 수정 기능 API**
    - **API 가 사용될 화면 보기**
        
      <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2F08e97bc0-2e31-41cb-a4b2-8baf809c4c47%2FUntitled.png?table=block&id=09c02286-8c8c-447e-9409-d59438305f73&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=960&userId=&cache=v2" width="200" height="400">
        
    - 선택한 게시글 할일카드의 `제목`, `작성 내용`을 수정할 수 있습니다. (작성자명)
        - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능
        - 할일 제목, 할일 내용을 수정하고 수정된 할일 정보는 Client 로 반환됩니다.
        - 서버에 게시글 수정을 요청할 때 비밀번호를 함께 전달합니다.
        - 선택한 게시글의 비밀번호와 요청할 때 함께 보낸 비밀번호가 일치할 경우에만 수정이 가능합니다.
    - 수정된 게시글 할일의 정보를 반환 받아 확인할 수 있습니다.
        - 반환 받은 할일 정보에는 `할일 제목`,`할일 내용`, `작성자` , `작성일`정보가 들어있습니다.
        - 반환 받은 게시글의 정보에 비밀번호는 제외 되어있습니다.
- [ ]  **🆕 할일카드 완료 기능 API**
    - **API 가 사용될 화면 보기**
        
        <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2F197c518e-48c2-4a70-8fed-67fcfb983af8%2FUntitled.png?table=block&id=00b21fb8-8477-4008-8b8a-844c57b92345&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=860&userId=&cache=v2" width="300" height="300">
        
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 할일카드 만 완료 가능
    - 완료처리 한 할일카드는 목록조회시 `완료 여부`필드가 TRUE 로 내려갑니다.
    - `완료 여부` 기본값은 FALSE
- [ ]  **🆕 댓글 작성 API**
    - **API 가 사용될 화면 보기**
        
        <img src="https://teamsparta.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F83c75a39-3aba-4ba4-a792-7aefe4b07895%2F9b4f8b70-ceb6-497f-b95b-58835c9af662%2FUntitled.png?table=block&id=8818689f-06c5-4507-bfa3-1b679fb17a20&spaceId=83c75a39-3aba-4ba4-a792-7aefe4b07895&width=770&userId=&cache=v2" width="300" height="400">
        
    - 토큰을 검사하여, 유효한 토큰일 경우에만 댓글 작성 가능
    - 선택한 할일의 DB 저장 유무를 확인하기
    - 선택한 할일이 있다면 댓글을 등록하고 등록된 댓글 반환하기
- [ ]  **🆕 댓글 수정 API**
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 수정 가능
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 수정하고 수정된 댓글 반환하기
- [ ]  **🆕 댓글 삭제 API**
    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 삭제 가능
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기
  
</details>

<details>
<summary>심화주차 개인과제</summary>

- [ ]  **🆕 DTO, Entity Test 추가하기**
    - `@Test` 를 사용해서 DTO 와 Entity Test 를 추가합니다.
    - User, Todo, Comment, DTO 에 존재하는 메서드들에 대해서 테스트를 추가합니다.
- [ ]  **🆕 Controller Test 추가하기**
    - `@WebMvcTest` 를 사용하여 Controller Test 를 추가합니다.
    - Todo, Comment Controller 에 대해서 테스트를 추가합니다.
- [ ]  **🆕 Service Test 추가하기**
    - `@ExtendWith` 를 사용하여 Service Test 를 추가합니다.
    - User, UserDetails, Todo, Comment Service 에 대해서 테스트를 추가합니다.
- [ ]  **🆕 Repository Test 추가하기**
    - `@DataJpaTest` 를 사용하여 Repository Test 를 추가합니다.
    - User, Todo, Comment Repository 에 대해서 테스트를 추가합니다.
  
</details>
