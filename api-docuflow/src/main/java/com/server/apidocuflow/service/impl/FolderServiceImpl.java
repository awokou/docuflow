package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.repository.FolderRepository;
import com.server.apidocuflow.service.FolderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
}
