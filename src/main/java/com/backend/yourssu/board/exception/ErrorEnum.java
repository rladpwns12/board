package com.backend.yourssu.board.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    /* 멤버 CRUD 오류 메세지 정의 */
    MEMBER_UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "MBS_000", "알 수 없는 사용자 관리 서비스 오류입니다."),
    MEMBER_DUPLICATED_PROPS(HttpStatus.BAD_REQUEST, "MBS_001", "중복된 속성입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MBS_002", "해당 UID 의 유저를 찾을 수 없습니다."),
    MEMBER_PASSWORD_NOT_CORRECT(HttpStatus.BAD_REQUEST, "MBS_003", "비밀번호가 일치하지 않습니다."),
    MEMBER_INPUT_NOT_FOUND(HttpStatus.BAD_REQUEST, "MBS_004", " 잘못된 입력입니다."),
    MEMBER_IMAGE_DELETE_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "MID_001", "삭제할 수 없는 이미지입니다."),
    MEMBER_FORMAT_ERROR(HttpStatus.BAD_REQUEST, "MBS_005", "잘못된 형식의 입력입니다."),
    MEMBER_DUPLICATED_ID(HttpStatus.CONFLICT,"MBS_006","중복된 ID 값입니다."),
    BANNED_MEMBER(HttpStatus.FORBIDDEN, "MBS_007", "정지된 유저 입니다."),
    MEMBER_INPUT_OVERLIMIT(HttpStatus.BAD_REQUEST, "MBS_008", "최대 입력을 초과하였습니다."),
    /* 멤버 CRUD 오류 메세지 정의 끝*/

    /*게시글 오류 메세지 정의 */
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "BRD_000", "해당 UID 의 게시글을 찾을 수 없습니다."),
    /*게시글 오류 메세지 정의 끝*/

    NO_AUTHORITY(HttpStatus.BAD_REQUEST, "AUT_000", "권한이 없습니다."),
    ETC(HttpStatus.INTERNAL_SERVER_ERROR, "ETC_000", "알 수 없는 서버 내부 오류입니다.");



    private ErrorResponse errorResponse;

    public String getMessage() {
        return this.errorResponse.getMessage();
    }

    public String getErrCode() {
        return this.errorResponse.getErrCode();
    }

    public HttpStatus getHttpStatus() {
        return this.errorResponse.getHttpStatus();
    }

    public static ErrorEnum valueOfMessage(String message){
        for(ErrorEnum errorEnum : ErrorEnum.values()){
            if(message.contains(errorEnum.getMessage()))
                return errorEnum;
        }
        return ETC;
    }

    ErrorEnum(HttpStatus httpStatus, String errCode, String message) {
        this.errorResponse = new ErrorResponse(httpStatus, errCode, message);
    }

    @Getter
    @Setter
    public class ErrorResponse {
        private HttpStatus httpStatus;
        private String errCode;
        private String message;

        public ErrorResponse(HttpStatus httpStatus, String errCode, String message) {
            this.httpStatus = httpStatus;
            this.errCode = errCode;
            this.message = message;
        }
    }

}
