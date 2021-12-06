package com.leandro1995.mvi.model

import com.leandro1995.mvi.retrofit.service.GetService

class User {

    suspend fun postList(
        response: (postList: MutableList<Post>) -> Unit,
        errorResponse: (code: Int, message: String) -> Unit
    ) {
        GetService.postList(
            ({ postList ->

                response(postList)
            }),
            ({ code, errorMessage ->

                errorResponse(code, errorMessage)
            })
        )
    }
}