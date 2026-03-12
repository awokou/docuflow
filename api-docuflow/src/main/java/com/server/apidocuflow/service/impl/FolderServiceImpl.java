package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.repository.FolderRepository;
import com.server.apidocuflow.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
}
