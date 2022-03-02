package com.frogobox.admob.source

import com.frogobox.admob.model.FrogoAdmobId
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/*
 * Created by faisalamir on 02/03/22
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

interface FrogoAdmobApiService {

    @GET("{json-file-name}.json")
    fun getFrogoAdmobId(
        @Path("json-file-name") jsonFileName: String
    ): Observable<FrogoAdmobId>

}