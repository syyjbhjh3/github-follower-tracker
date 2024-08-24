# github-follow

### __*Github-Follow를 탐색하고 맞팔로우, 언팔로우 해주는 Code입니다.*__
#### Notion - https://syyjbhjh7.notion.site/GitHub-Follower-Tracker-fba53711eea14263b92e76e4c32de88d?pvs=4

## 제작동기

- 어느샌가부터 Follower가 늘고, 확인하면 맞팔로우를 해주고 있었다!  
- 맞팔로우를 하면 언팔로우를 하는 User들을 발견…!!  
- 소수일때는 관리가 가능했지만 30명이 넘어가면서부터 관리가 힘들어서 만들기 시작!  
- **SRE & Pipleline 구축시, 간단한 Application이 필요했는데 구현도 간단하고, 연동도 내 맘이니 최고다!**  


## 개발환경 설정

#### Version

- Java : 22
- Spring Boot : 3.3.2

#### Lombok & jackson Dependencies 설정

- Lomokb  
implementation 'org.projectlombok:lombok'  
annotationProcessor('org.projectlombok:lombok')   


- jackson  
implementation 'com.fasterxml.jackson.core:jackson-databind:2.12.3'
