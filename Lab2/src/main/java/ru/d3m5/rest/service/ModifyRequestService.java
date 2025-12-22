package ru.d3m5.rest.service;

import org.springframework.stereotype.Service;
import ru.d3m5.rest.model.Request;
@Service
public interface ModifyRequestService {
    void modify(Request request);

}
