import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

data class Berita(val judul: String, val kategori: String)

fun sumberBerita(): Flow<Berita> = flow {
    val daftarBerita = listOf(
        Berita("Ikan Cupang 600 Juta", "Unik"),
        Berita("Gempa di Laut Jawa", "Bencana"),
        Berita("HP Layar Tembus Pandang", "Tech"),
        Berita("Pria Menikahi Rice Cooker", "Unik")
    )
    
    for (berita in daftarBerita) {
        delay(2000L) // Jeda 2 detik
        emit(berita) 
    }
}

suspend fun ambilDetailBerita(): String {
    delay(1000L) 
    return "   -> Isi artikel berhasil dimuat."
}

fun main() = runBlocking {
    val jumlahDibaca = MutableStateFlow(0)
    
    sumberBerita()
        .filter { it.kategori == "Tech" || it.kategori == "Unik" }
        .map { "[${it.kategori.uppercase()}] ${it.judul}" } 
        .collect { berita ->
            
            // Menambah angka statistik
            jumlahDibaca.value += 1
            
            // Mencetak judul dan statisik dalam 1 baris
            println("$berita (Total dibaca: ${jumlahDibaca.value})")
            
            // Download detail di background
            launch {
                println(ambilDetailBerita())
            }
        }
}
