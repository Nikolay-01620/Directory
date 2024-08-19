package com.example.utils

import com.example.derectory.ui.model.Directory
import com.example.domain.model.DirectoryDomain

fun DirectoryDomain.toDomain() = Directory(
    id = id, name = name, phoneNumber = phoneNumber
)

