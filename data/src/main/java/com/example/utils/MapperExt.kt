package com.example.utils

import com.example.data.model.DirectoryData
import com.example.domain.model.DirectoryDomain

fun DirectoryDomain.toDomain() = DirectoryData(
    id = id, name = name, phoneNumber = phoneNumber
)