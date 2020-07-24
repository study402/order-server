package com.example.orderserver.bean;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseResult extends JSONObject {

	public static ObjectMapper objectMapper = null;

	public ResponseResult() {
		this.put("resultCode", ResultCode.RESULT_SUCCESS);
	}


	public static ResponseResult getResult(int resultCode, String msg) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.put("resultCode", resultCode);
		responseResult.put("msg", msg);
		return responseResult;
	}

	public static ResponseResult failResult(String msg) {
		return getResult(ResultCode.RESULT_FAIL, msg);
	}

	public static ResponseResult successResult() {
		return new ResponseResult();
	}

	public static ResponseResult successResult(String msg) {
		return getResult(ResultCode.RESULT_SUCCESS, msg);
	}

	public static ResponseResult accessDenied(String msg) {
		return getResult(ResultCode.RESULT_ACCESS_DENIED, msg);
	}


	public ResponseResult setResultCode(int resultCode) {
		this.put("resultCode", resultCode);
		return this;
	}

	public ResponseResult setMsg(String msg) {
		this.put("msg", msg);
		return this;
	}

	public void putObject(Object o) {
		if (o != null) {
			try {
				String value = objectMapper.writeValueAsString(o);
				Map map = objectMapper.readValue(value, Map.class);
				this.putAll(map);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
