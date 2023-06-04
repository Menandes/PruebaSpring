package com.example.SpringProject.Service.Impl;

import com.example.SpringProject.Model.Employee;
import com.example.SpringProject.Model.EmployeeResponse;
import com.example.SpringProject.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String baseUrl = "https://dummy.restapiexample.com/api/v1/employees";
    private List<Employee> employeeList = Collections.emptyList();

    @Override
    public EmployeeResponse getAllEmployees() {
        EmployeeResponse employeeResponse = null;
        try {
            String url = "https://dummy.restapiexample.com/api/v1/employees";
            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new Exception("Unexpected response code: " + response.code());
            }
            String responseBody = response.body().string();
            employeeResponse = objectMapper.readValue(responseBody, EmployeeResponse.class);
            return employeeResponse;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EmployeeResponse getEmployeeById(int id) {
        EmployeeResponse employee = null;
        try {
            String url = "https://dummy.restapiexample.com/api/v1/employee/" + id;
            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new Exception("Unexpected response code: " + response.code());
            }
            String responseBody = response.body().string();
            EmployeeResponse employeeResponse = objectMapper.readValue(responseBody, EmployeeResponse.class);
            return employeeResponse;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return employee;
        }
    }
}

