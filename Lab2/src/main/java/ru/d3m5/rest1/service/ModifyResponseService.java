package ru.d3m5.rest1.service;

import org.springframework.stereotype.Service;
import ru.d3m5.rest1.model.Response;
@Service
public interface ModifyResponseService {
    Response modify (Response response);
}
