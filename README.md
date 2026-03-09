# 칸반 보드 태스크(리팩터링)

# 기능 구현 사항

## 리팩토링 
- [x] TaskCardData 클래스 추가
- [x] 태그 최대 개수, 태그 당 최대 글자 수 입력 받도록 변경
- [x] Color 클래스 변경하기


## 테스트 시나리오
- [x] 단위 테스트 구현하기
  - TaskCardData의 모든 값이 빈 값 또는 null 이 아니면 예외가 발생하지 않는다.
  - TaskCardData의 script만 빈 값이 들어오면 예외가 발생하지 않는다.
  - TaskCardData의 tags만 빈 값이 들어오면 예외가 발생하지 않는다.
  - TaskCardData의 title이 빈 값이면 예외가 발생한다.
  - TaskCardData의 title이 null이면 예외가 발생한다.
  - TaskCardData의 script가 null이면 예외가 발생한다.
  - TaskCardData의 tags가 null이면 예외가 발생한다.
  - TaskCardData의 nickname이 null이면 예외가 발생한다.
  - TaskCardData의 nickname이 빈 값이면 예외가 발생한다.

- [x] UI 테스트 구현하기
  - Script에 빈 값이 들어오면 Script 컴포넌트가 출력되지 않는다.
  - Script에 빈 값이 들어오지 않으면 Script 컴포넌트가 출력된다.
  - Tags에 빈 태그 리스트가 들어오면 Tags 컴포넌트가 출력되지 않는다.
  - Tags에 요소가 1개 이상인 태그 리스트가 들어오면 Tags 컴포넌트가 출력된다.
  - Tags의 태그 최대 개수를 6개로 설정하면 6개까지 Tag 컴포넌트가 출력된다.
  - TaskCardData의 모든 값이 빈 값, null이 아니면 title, script, tags, nickname 컴포넌트가 출력된다.
  
