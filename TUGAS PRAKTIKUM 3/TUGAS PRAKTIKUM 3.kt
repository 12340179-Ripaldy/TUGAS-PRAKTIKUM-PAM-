package com.ripaldy.myprofileapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myprofileapp.shared.generated.resources.* // Wajib untuk baca gambar
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        MyProfileApp()
    }
}

@Composable
fun MyProfileApp() {
    var showContactInfo by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader(
                name = "Ripaldy SAputra",
                role = "Mahasiswa Informatika ITERA"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProfileCard(
                    title = "Tentang Saya",
                    content = "Mahasiswa Informatika dengan minat kuat dalam eksplorasi dan pengembangan teknologi perangkat lunak. " +
                            "Saat ini berfokus mempelajari pengembangan Web, aplikasi Mobile, dan Kecerdasan Buatan (AI). "
                )

                Button(
                    onClick = { showContactInfo = !showContactInfo },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = if (showContactInfo) "Sembunyikan Kontak" else "Tampilkan Kontak")
                }

                AnimatedVisibility(visible = showContactInfo) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text("Informasi Kontak", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
                            InfoItem(icon = "✉️", text = "paldy1512@gmail.com")
                            InfoItem(icon = "📞", text = "+62 812 3456 7890")
                            InfoItem(icon = "📍", text = "Lampung Selatan")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String, role: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            // COVER GAMBAR DARI LOKAL
            Image(
                painter = painterResource(Res.drawable.cover),
                contentDescription = "Cover",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = ContentScale.Crop
            )

            // PROFIL GAMBAR DARI LOKAL
            Image(
                painter = painterResource(Res.drawable.profil),
                contentDescription = "Profil",
                modifier = Modifier
                    .padding(top = 80.dp)
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = role, fontSize = 16.sp, color = Color.Gray)
    }
}

@Composable
fun ProfileCard(title: String, content: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = content, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}

@Composable
fun InfoItem(icon: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = icon, fontSize = 20.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 14.sp)
    }
}
