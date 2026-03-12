package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.repository.DocumentRepository;
import com.server.apidocuflow.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository  documentRepository;
}
