# PortfolioManager
일하면서 수행한 여러 프로젝트들을 관리하는 목적으로 만든 PortfolioManager 프로젝트 입니다.

## Getting Started
해당 프로젝트는 JPA 공부를 목적으로 진행 중인 미니 프로젝트 입니다.
현재, 사용자등록, 프로젝트 추가 가능까지 구현 하였으며, 지속적으로 기능 및 Exception을 추가하여 고도화 할 예정입니다.
메이븐을 이용한 멀티모듈 프로젝트로 구성되어 있으며, 공통코드 및 환경 설정은 Common-lib.jar 말아 제공하고 있으며,
실제 호출은 api 모듈에 있습니다.

### 실행환경
- JDK 1.8이상
- Maven 3이상

## APIs
### 사용자 등록
<blockquote>
<p>URL : /api/v1/user/sign </p>
<p>Method : POST </p>
</blockquote>
<table>
<thead>
<tr>
<th align="left">Property</th>
<th align="left">Data Type</th>
<th align="left">Mandatory</th>
</tr>
</thead>
<tbody>
<tr>
<td align="left">userEmail</td>
<td align="left">String<String></td>
<td align="left">Y</td>
</tr>
  <tr>
<td align="left">userPassword</td>
<td align="left">String<String></td>
<td align="left">Y</td>
</tr>
</tbody>
</table>

## TODO
 - 기능구현 추가, JWT 인증 
