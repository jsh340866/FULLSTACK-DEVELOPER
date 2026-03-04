# 풀스택 개발자 프로젝트 수업 과정 3월

## 26-03-03
### Git 명령어 사용법
```
git add ""
git add *
git commit -m ""
git commit --amend //마지막 생성한 커밋 수정
git status
git log
git log --oneline
git reflog
git reset --hard hash //돌아간 커밋 이후의 변경 이력을 전부 삭제, 잘안씀 하드리셋 그룹작업에 위험함
git reset --soft hash //변경 이력 삭제, 변경 내용은 남아있음, 인덱스 초기화(git add가 안되어 있는 상태)(status초기화)
git reset --mixed hasg //변경 이력 삭제, 변경 내용은 남이있음, 인덱스도 유지(git add까지 되어 있음)
git branch //브렌치 확인
git branch "" //생성
git branch -d "" //삭제
git switch "" == git checkout "" //변경
git merge "" //브렌치 병합
git merge "" --no-ff -m "" //브렌치 병합후 새로운 커밋으로 생성
git merge --continue //이어서 병합 진행
git remote add origin https://github.com/jsh340866/TESTREPO-2026-03-SHARE.git 
git remote -v //연결 확인
git push --set-upstream origin master
git push origin //깃허브에 파일 넣기
git pull origin //깃허브 파일 가져오기
git push --force 브랜치이름
git fetch origin //깃허브 브랜치 가져오기
git clone 주소 //
cd tab클릭

```
### GitHub 협업
```
main(조장) - branch rules(x - Lock Branch)
develop(조장) - branch rules()
 - feature(조원)	
 - feature(조원)
 - feature(조원)
 - feature(조원)

파일을 merge하려면 최소 한명의 승인이 필요

[조장]
1. Organization 생성
2. Repository 생성
3. Branch 생성 (Main, Dev)
4. 팀원 초대 (Organization -> Settings -> Collaborators and Teams -> Add People)
5. 권한 설정 (Organization -> Settings -> Member Privileges -> Write 권한)
6. Repository's Branch Rule 설정 (Organization -> Settings -> Branches -> 
 main : Lock Branch
 dev : Require a pull request before merging

[조원]

1. Organiztion 의 Repository 확인
2. 본인이름/기능명 branch 생성
ex) 홍길동/회원가입기능
3.  dev branch에 pull request 요청
4. 서로 approve 댓글 추가해서 dev에 mergr 해보기

[Issue 만들기]

1. 기본 ISSUE 만들기 (Organization -> Repository -> Issue -> New Issue)
1-1.LABEL - 태그 붙이기 (Labels -> Edit labels -> New label)
1-2.TYPE - TASK/FEATURE/BUG
1-3.MILESTONE - 업무 상위 일정

라벨 milestone (Milestone -> New milestone) 
 - [ ] 화면설계

[Issue]

[pl]요구사항정의작업
 - [ ] 요구사항 내용 정리
 - [ ] USECASE
 - [ ] USECASE 명세서

[PL] 요구사항 정의-정승원
 - [ ] 사전인터뷰
 - [ ] Draw.io 그림그리기
 - [ ] 파일로 저장

[PL] USECASE-정승원
 - [ ] Frame 만들기
 - [ ] Actor 만들기
 - [ ] usecase 단위 만들기
 - [ ] 관계선 정의하기

[PL] USECASE명세서-정승원
 - [ ] USECASE이름지정
 - [ ] 사전/사후 관계
 - [ ] 정상흐름
 - [ ] 대안흐름
 - [ ] 예외흐름

조장 or 조원
Create a bracnh
생성된 branch 조원 전달

```
