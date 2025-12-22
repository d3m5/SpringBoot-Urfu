package ru.d3m5.rest1.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.d3m5.rest1.model.Request;
@Service
public interface ModifyRequestService {
    void modify(Request request);

}
