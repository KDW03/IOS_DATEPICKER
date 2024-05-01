# DatePicker
[IOS_DatePicker](https://github.com/KDW03/IOS_DATEPICKER)는 Jetpack Compose UI를 사용하여 개발된 iOS 스타일의 한국식 DatePicker 라이브러리입니다. 
IOS_DatePicker는 여러 커스터마이징 옵션을 제공합니다.

#### Parameters

| Parameter                | Type      | Description                                                     |
|--------------------------|-----------|-----------------------------------------------------------------|
| `offset`                 | Int       | 피커에 표시할 항목 수 [**default: 3**]                            |
| `yearsRange`             | IntRange  | 선택 가능한 최소 및 최대 연도 [**default: IntRange(1923, 2121)**]  |
| `startDate`              | Long      | 피커에 표시될 시작 날짜, 밀리초 단위 [**default: 현재 날짜**]          |
| `textSize`               | Int       | 피커 텍스트의 크기 [**default: 16**]               |
| `isTransformationEnabled`| Boolean   | 선택되지 않은 항목에 대한 변환 효과 활성화 여부 (예: 회전, 확대) [**default: true**] |
| `selectorEffectEnabled`  | Boolean   | 선택 시 햅틱 효과 활성화 여부 [**default: false**]               |
| `selectViewEnable`       | Boolean   | 선택된 항목을 강조하는 SelectView 활성화 여부 [**default: false**] |
| `onDateChanged`          | (Int, Int, Int) -> Unit | 피커 값이 변경될 때 호출되는 콜백 함수, 연, 월, 일을 인자로 받습니다. |
| `darkModeEnabled`        | Boolean   | 다크모드 활성화 여부 [**default: false**]                         |

<br>
<br>
