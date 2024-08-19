package com.example.utils

import com.example.database.DirectoryData
import com.example.domain.model.DirectoryDomain

fun DirectoryData.toDomain() = DirectoryDomain(
    id = id, name = name, phoneNumber = phoneNumber
)
