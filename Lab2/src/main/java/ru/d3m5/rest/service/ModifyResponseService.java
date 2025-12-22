package ru.d3m5.rest.service;

import org.springframework.stereotype.Service;
import ru.d3m5.rest.model.Response;
@Service
public interface ModifyResponseService {
    Response modify (Response response);
}
