package com.inside.developed.zimadtestproject.feature.detail

import android.os.Bundle
import com.inside.developed.zimadtestproject.R
import com.inside.developed.zimadtestproject.core.base.BaseActivity
import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.CatsDogsModel
import com.inside.developed.zimadtestproject.util.extensions.getData
import com.inside.developed.zimadtestproject.util.extensions.loadFromUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailScreen : BaseActivity() {
    override fun obtainLayoutResId() = R.layout.activity_detail
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData(getData())
    }

    fun initData(catsDogsModel: CatsDogsModel) {
        tvAnimalName.text = catsDogsModel.title
        ivAnimalImage.loadFromUrl(catsDogsModel.url)
    }
}