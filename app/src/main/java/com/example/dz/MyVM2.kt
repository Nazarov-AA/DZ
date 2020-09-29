package com.example.k_02

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dz.MainActivity6
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class MyVM2 : ViewModel() {

    var potatoes1 = MutableLiveData(0)
    var cabbage1 = MutableLiveData(0)
    var beet1 = MutableLiveData(0)

    var potatoes2 = MutableLiveData(0)
    var cabbage2 = MutableLiveData(0)
    var beet2 = MutableLiveData(0)

    var potatoes3 = MutableLiveData(0)
    var cabbage3 = MutableLiveData(0)
    var beet3 = MutableLiveData(0)

    var winner = MutableLiveData(" ")


    fun update() {

        var p1: Int? = potatoes1.value
        var c1: Int? = cabbage1.value
        var b1: Int? = beet1.value

        var p2: Int? = potatoes2.value
        var c2: Int? = cabbage2.value
        var b2: Int? = beet2.value

        var p3: Int? = potatoes3.value
        var c3: Int? = cabbage3.value
        var b3: Int? = beet3.value

        var f = false


            CoroutineScope(Dispatchers.IO).launch {

                while (f == false) {
                    delay(1000)
                    p1 = p1?.plus(Random.nextInt(0, 10))
                    c1 = c1?.plus(Random.nextInt(0, 10))
                    b1 = b1?.plus(Random.nextInt(0, 10))

                    potatoes1.postValue(p1)
                    cabbage1.postValue(c1)
                    beet1.postValue(b1)

                    if (p1!! >= 100 && c1!! >= 100 && b1!! >= 100) {
                        f = true
                        winner.postValue("Минская область первой достигла показателей в 100т")
                    }
                }


            }


        CoroutineScope(Dispatchers.IO).launch {

            while  (f == false) {
                delay(1000)
                p2 = p2?.plus(Random.nextInt(0, 10))
                c2 = c2?.plus(Random.nextInt(0, 10))
                b2 = b2?.plus(Random.nextInt(0, 10))

                potatoes2.postValue(p2)
                cabbage2.postValue(c2)
                beet2.postValue(b2)

                if (p2!! >= 100 && c2!! >= 100 && b2!! >= 100) {
                    f = true
                    winner.postValue("Брестская область первой достигла показателей в 100т")
                }
            }


        }

        CoroutineScope(Dispatchers.IO).launch {

            while  (f == false) {
                delay(1000)
                p3 = p3?.plus(Random.nextInt(0, 10))
                c3 = c3?.plus(Random.nextInt(0, 10))
                b3 = b3?.plus(Random.nextInt(0, 10))

                potatoes3.postValue(p3)
                cabbage3.postValue(c3)
                beet3.postValue(b3)

                if (p3!! >= 100 && c3!! >= 100 && b3!! >= 100) {
                    f = true
                    winner.postValue("Могилевская область первой достигла показателей в 100т")
                }
            }


        }
    }

    }
