# DatePicker
[IOS_DatePicker](https://github.com/KDW03/IOS_DATEPICKER)는 Jetpack Compose UI를 사용하여 개발된 iOS 스타일의 한국식 DatePicker 라이브러리입니다. 
IOS_DatePicker는 여러 커스터마이징 옵션을 제공합니다.


#### darkModeEnabled

<p align="start">
  
![Screen_Recording_20240501_234226_IOS_DatePicker_1-ezgif com-resize](https://github.com/KDW03/IOS_DATEPICKER/assets/109224863/23dcbd88-f80b-49b0-aa27-3ee7cfa7a949)
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
![Screen_Recording_20240501_232842_IOS_DatePicker-ezgif com-resize](https://github.com/KDW03/IOS_DATEPICKER/assets/109224863/41965f8d-0386-4b48-ae2a-dadd1d22af0a)

</p>


#### selectViewEnable

<p align="start">
  
![Screen_Recording_20240501_233541_IOS_DatePicker_1-ezgif com-crop](https://github.com/KDW03/IOS_DATEPICKER/assets/109224863/9657f81b-09a4-421f-9142-973d13365ff8)
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
![Screen_Recording_20240501_233541_IOS_DatePicker-ezgif com-crop](https://github.com/KDW03/IOS_DATEPICKER/assets/109224863/5e51e8f2-9d69-4bd3-b629-3c4e17b297b5)
  
</p>

#### isTransformationEnabled

<p align="start">

![Screen_Recording_20240501_234226_IOS_DatePicker_2-ezgif com-crop](https://github.com/KDW03/IOS_DATEPICKER/assets/109224863/3c60105e-ac8e-4c90-afe1-28407b1012fc)
  
</p>

<br>


# Usage

<br>

```kotlin
SpinnerDatePicker(
  modifier = Modifier,
	offset =/*offset*/,
	yearsRange = IntRange(/*minYear*/,/*maxYear*/),
	startDate =/*startDate*/,
	textStyle =/*textStyle*/,
  isTransformationEnabled = /*isTransformationEnabled*/,
	selectorEffectEnabled =/*selectorEffectEnabled*/,
  selectViewEnable =/*selectViewEnable*/,
	darkModeEnabled =/*darkModeEnabled*/,
	onDateChanged = { year, month, day ->
	  /*Handle date changes*/
	}
)
```


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

## Implementation Gradle

###### Add it in your root build.gradle at the end of repositories:

```groovy
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

###### Add the dependency

```groovy
	dependencies {
	        implementation 'com.github.KDW03:IOS_DATEPICKER:1.0.3'
	}
```




