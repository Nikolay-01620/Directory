package com.example.directory.utils

import com.example.data.model.DirectoryData
import com.example.directory.ui.model.Directory
import com.example.domain.model.DirectoryDomain

fun DirectoryData.toDomain() = DirectoryDomain(
    id = id, name = name, phoneNumber = phoneNumber
)

