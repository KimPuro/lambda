/*001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오*/
SELECT team_name FROM team ORDER BY team_name ASC;

/*
002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오*/
SELECT DISTINCT position FROM player WHERE position IS NOT NULL OR position = '';

/*
003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오
*/

SELECT DISTINCT IF(position = '', '신입', position) AS Position
FROM player;

/*
004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
*/

SELECT player_name
FROM player
WHERE team_id = 'K02' AND position = 'GK';

/*
005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.*/
SELECT player_name
FROM player
WHERE team_id = 'K02' AND player_name LIKE '고%' AND height >= 170;
/*
 005-1 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. (팀 ID를 모를 경우)
 */
SELECT p.player_name
FROM player AS p
         JOIN team AS t ON p.team_id = t.team_id
WHERE t.region_name = '수원'
  AND p.player_name LIKE '고%'
  AND p.height >= 170;
/*
 006.다음 조건을 만족하는 선수명단을 출력하시오
 소속팀이 삼성블루윙즈이거나
 드래곤즈에 소속된 선수들이어야 하고,
 포지션이 미드필더(MF:Midfielder)이어야 한다.
 키는 170 센티미터 이상이고 180 이하여야 한다.
 */
SELECT p.player_name
FROM player AS p
         JOIN team AS t ON p.team_id = t.team_id
WHERE (t.team_name = '삼성블루윙즈' OR t.team_name = '드래곤즈')
  AND p.position = 'MF'
  AND p.height >= 170
  AND p.height <= 180;

/*
007. 수원을 연고지로 하는 골키퍼는 누구인가?
*/
SELECT player_name
FROM player
JOIN team ON player.team_id = team.team_id
WHERE team.region_name = '수원' AND player.position = 'GK';

/*
008. 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오 키와 몸무게가 없으면 "0" 으로 표시하시오 키와 몸무게는 내림차순으로 정렬하시오
*/
SELECT player_name,
       IFNULL(NULLIF(height, ''), 0) AS height,
       IFNULL(NULLIF(weight, ''), 0) AS weight
FROM player
         JOIN team ON player.team_id = team.team_id
WHERE team.region_name = '서울'
ORDER BY height DESC, weight DESC;

/*
009. 서울팀 선수들 이름과 포지션과 키(cm를 추가하여 출력)와 몸무게(kg을 추가하여 출력)와  각 선수의 BMI지수를 출력하시오 단,
키와 몸무게가 없으면 "0" 표시하시오 BMI는 "NONE" 으로 표시하시오(as bmi)
최종 결과는 이름내림차순으로 정렬하시오
*/
SELECT player_name, position,
   IFNULL(NULLIF(height,''), 0) AS height,
   IFNULL(NULLIF(weight,''), 0) AS weight,
       IF(height = '' OR weight = '', 'NONE', ROUND(weight / ((height / 100) * (height / 100)), 2)) AS bmi
FROM player
JOIN team ON player.team_id = team.team_id
WHERE team.region_name = '서울'
ORDER BY player_name DESC;
