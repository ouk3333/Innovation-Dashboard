package com.vms.sundance.enums;

public final class IMSPErrorCode {

	public static final int OK = 200; // OK
	
	public static final int FieldrequiredNotExist 	= 201; // 필수 입력 항목이 비어있는 경우
	public static final int NotExistDataOrURL 		= 202; //  존재하지 않는 URL
	
	public static final int UnknownCommand 				= 400; // 요청한 Command 정보가 없거나 Command 필드가 누락된 경우
	public static final int UnknownContentEncoding 	= 401; // 요청한 ContentEncoding 방법을 지원하지 않거나 누락된 경우
	public static final int InvalidContent 				= 402; // ContentLength 정보가 올바르지 않거나, 필요한 Content 필드가 누락된 경우
	public static final int InvalidEndSyntax 			= 403; // Header 의 끝 정보(CRLF)가 없는 경우
	public static final int InvalidSyntax 				= 404; // 알 수 없는 구문인 경우
	public static final int AuthorizeFail 				= 405; // 인증이 실패한 경우
	public static final int Unauthorized 				= 406; // 인증되지 않았을 경우
	public static final int UserPasswordExpired 		= 407; // 사용자 패스워드가 만료된 경우
	public static final int InvalidPassword 			= 408; // 패스워드가 유효하지 않은 경우
	public static final int PermissionDenied 			= 409; // 권한이 제한된 경우
	public static final int MaxConnectionError 			= 410; // 커넥션 개수 초과
	public static final int InvaildSessionID 			= 411; // 세션 아이디가 일치하지 않은 경우
	
	public static final int MismatchVersion 		= 500; // 버전이 맞지 않는 경우
	public static final int InternalServerError 	= 501; // 서버에서 에러가 발생한 경우
	public static final int DataStoreNotReady 		= 502; // 서버의 DataStore 가 갱신중이거나, 준비되지 않은 경우
	public static final int RequestDataNotFound 	= 503; // 요청한 데이터에 대한 결과 값을 찾지 못한 경우
	public static final int ResponseContentError 	= 504; // 서버에서 응답 메시지를 만드는 도중 에러가 발생한 경우
	public static final int MainServerNotReady 		= 505; // 관리서버와 연결되어 있지 않은 경우
	
	public static final int ChannelNotFound 						= 600; // 해당 채널을 찾을 수 없음
	public static final int HealthCheckIsDisabled 					= 601; // 저장 서버 헬스 체크 설정이 되어 있지 않은 경우
	public static final int RequestedCommandIsNotAvailable 		= 602; // 해당 기능을 지원하지 않은 경우
	public static final int RequestedCommandExecutionFailed 		= 603; // 해당 기능을 실행에 실패한 경우
	public static final int RequestedNumberIsNotSet 				= 604; // 요청한 번호대의 Preset 또는 Tour 설정되어 있지 않은 경우
	public static final int RequestedNumberIsAlreadySet 			= 605; // 요청한 번호대의 Preset 또는 Tour가 이미 설정되어 있는 경우
	public static final int StorageSeverIsNotAvailable 			= 606; // 저장 서버가 정상 동작하고 있지 않은 경우
	public static final int WatchDogIsNotAvailable 				= 607; // Watch Dog이 정상 동작하고 있지 않은 경우
	public static final int TheDeviceIsBeingUsedByAnotherUser 	= 608; // 오디오 장치가 다른 사용자에게 사용되고 있는 경우
}
