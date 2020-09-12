    package com.adidas.ys.http.transformers

import javax.validation.constraints.NotBlank

interface NameTransformer {
    fun transform(@NotBlank name: String) : String
}