package com.inside.developed.zimadtestproject.core.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import com.inside.developed.zimadtestproject.core.base.BaseViewModel
import com.inside.developed.zimadtestproject.core.domain.repository.login.MainRepository
import com.inside.developed.zimadtestproject.model.remote.rest.entity.response.CatsDogsModel
import com.inside.developed.zimadtestproject.util.extensions.threadingSubscribe

class MainViewModel(private val mainRepository: MainRepository) : BaseViewModel() {
    init {
        getCats()
        getDogs()
    }

    var rvCatPosition: Int? = null
    var rvDogPosition: Int? = null

    val catsLiveData = MutableLiveData<ArrayList<CatsDogsModel>>()
    val dogsLiveData = MutableLiveData<ArrayList<CatsDogsModel>>()

    private fun getCats() {
        val disposable = mainRepository.getCats()
            .threadingSubscribe()
            .subscribe({
                catsLiveData.value = it.data
            }, {})
        compositeDisposable.add(disposable)
    }

    private fun getDogs() {
        val disposable = mainRepository.getDogs()
            .threadingSubscribe()
            .subscribe({
                dogsLiveData.value = it.data
            }, {})
        compositeDisposable.add(disposable)
    }

    fun setRvCatPos(pos: Int){
        rvCatPosition = pos
    }

   fun getRvCatsPos() = rvCatPosition

    fun setRvDogPos(pos: Int){
        rvDogPosition = pos
    }

    fun getRvDogsPos() = rvDogPosition
}