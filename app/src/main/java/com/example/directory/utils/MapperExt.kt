package com.example.directory.utils

import com.example.directory.ui.model.Directory
import com.example.domain.model.DirectoryDomain


fun DirectoryDomain.toDomain() = Directory(
    id = id, name = name, phoneNumber = phoneNumber
)

