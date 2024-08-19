package com.example.utils

import com.example.database.DirectoryData
import com.example.domain.model.DirectoryDomain

fun DirectoryDomain.toDomain() = DirectoryData(
    id = id, name = name, phoneNumber = phoneNumber
)