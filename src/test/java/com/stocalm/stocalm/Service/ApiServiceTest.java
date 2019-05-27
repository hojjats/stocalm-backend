package com.stocalm.stocalm.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ApiServiceTest {

    @Mock
    private ApiService apiService;

    @Test
    void getRequest() {
        when(apiService.getRequest("testStringUrl")).thenReturn("GET content");
        apiService.getRequest("testStringUrl");
        verify(apiService).getRequest("testStringUrl");
    }

    @DisplayName("Calls the real method, to httpbin/get")
    @Test
    void getRequestCallRealMethod() {
        when(apiService.getRequest("https://httpbin.org/get")).thenCallRealMethod();
        String content = apiService.getRequest("https://httpbin.org/get");
        assertEquals(true, content.contains("https://httpbin.org/get"));
    }

    @Test
    void getRequestWithParams() {
        Map<String, String> newMap = new HashMap<>();
        when(apiService.getRequestWithParams(anyString(), anyMap())).thenReturn("GET content with params");
        apiService.getRequestWithParams("testStringUrl", newMap);
        verify(apiService).getRequestWithParams("testStringUrl", newMap);
    }

    @Test
    void getRequestWithParamsCallRealMethod() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("user", "1");
        when(apiService.getRequestWithParams(anyString(), anyMap())).thenCallRealMethod();

        apiService.getRequestWithParams("testStringUrl", paramsMap);
        verify(apiService).getRequestWithParams("testStringUrl", paramsMap);
    }
}