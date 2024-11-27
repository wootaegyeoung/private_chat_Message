# private_chat_Message
for Linkverse moim project, i can 

## STOMP1113 : 
1. 웹소캣 할당
2. 채팅방 생성.
3. 채팅방 기반 메세징
4. 메세지 시간 표시
5. 메세지 사용자 표시
5. 과거 채팅 목록 loading

queue : 생성된 채팅방을 socket을 통해서 pub/sub

topic : 메세징 브로커 pub/sub

## Next :
1. 최적화에서 구현된 채팅방의 독립성 및 고유성 보장<br>
    1-1. 현재 같은 이름의 사용자와 채팅방에대한 허용이 있음.

2. jwt와 SpringSecurity 기반의 사용자 접근 제한.<br>
    권한 없는 다른 사용자의 채팅방 소켓의 접근 제한

3. 이를 repository 와 domain 저장방식을 추가

4. 메모리 최적화

5. 대용량 사용자 유지 및 보수에 대한 리팩토링