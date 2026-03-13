package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.repository.DocumentRepository;
import com.server.apidocuflow.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository  documentRepository;
}
