package com.example.directory.ui.screens.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val directoryRepository: DirectoryRepository) : ViewModel() {

    private val _contacts = MutableStateFlow<List<DirectoryDomain>>(emptyList())
    val contacts: StateFlow<List<DirectoryDomain>> = _contacts.asStateFlow()

    private var allContacts = emptyList<DirectoryDomain>()

    init {
        loadContacts()
    }

    /** Когда приложение запускается, оно должно загрузить
    все контакты из какого-то источника данных, например,
    из базы данных, сети или файла. Функция loadContacts()
    делает именно это — она загружает все контакты через
    directoryRepository.getAllContacts().*/
    fun loadContacts() {
        viewModelScope.launch {
            val contacts = directoryRepository.getAllContacts()
            /** После загрузки все контакты сохраняются в переменной
            allContacts. Эта переменная используется как исходный
            список контактов, по которому происходит фильтрация при поиске.*/
            allContacts = contacts
            _contacts.value = contacts
            Log.d("MainScreen", contacts.toString())
        }
    }

    fun searchContacts(
        /** Функция принимает поисковую строку query,
        которую вводит пользователь. */
        query: String
    ) {
        /** Если query пустая строка,
        функция возвращает пустой список,
        так как нет смысла искать что-то без
        указания конкретного запроса.*/
        if (query.isEmpty()) {
            _contacts.value = allContacts


        } else {
            val searchTerms =
                /** Ваша поисковая строка query раскалывается(split) на
                отдельные слова (термины) по пробелам.
                Например, если пользователь вводит John Doe,
                то строка query будет разбита на два элемента: ["John", "Doe"]. */
                query.split(" ")

                    /**Этот метод фильтрует пустые строки,
                    которые могут возникнуть, если пользователь случайно
                    ввел лишние пробелы. В результате, в searchTerms
                    будут только непустые слова. */
                    .filter { it.isNotEmpty() }

            /** Здесь происходит фильтрация всех контактов
            allContacts с использованием условия, описанного в блоке filter. */
            _contacts.value = allContacts.filter { contact ->

                /** searchTerms — это список всех слов, которые
                пользователь ввел в поисковую строку, разделенных по пробелам.
                Например, если пользователь ввел John Doe 123,
                то searchTerms будет содержать три элемента: ["John", "Doe", "123"].

                all { term -> ... } — это функция высшего
                порядка, которая проверяет, соответствует
                ли контакт всем терминам из списка searchTerms. */
                searchTerms.all { term ->
                    /** Проверяем, содержится ли слово, которое
                    ты ввел ("John" или "Doe"), в имени контакта (contact.name)
                    Если контакт зовут "John Smith", то слово "John" будет найдено в имени.

                    Флаг ignoreCase = true в методе contains используется для того,
                    чтобы поиск не зависел от регистра букв (то есть, чтобы он был
                    нечувствителен к разнице между заглавными и строчными буквами) */
                    contact.name.contains(term, ignoreCase = true) ||
                            contact.secondName.contains(term, ignoreCase = true) ||
                            contact.phoneNumber.contains(term)
                }
            }
        }
    }
}
