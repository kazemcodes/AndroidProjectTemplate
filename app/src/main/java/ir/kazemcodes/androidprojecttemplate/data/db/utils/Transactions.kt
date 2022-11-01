package ir.kazemcodes.androidprojecttemplate.data.db.utils

interface Transactions {

  suspend fun <T> run(action: suspend () -> T): T

}
