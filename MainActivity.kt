
package com.example.smartbusai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val SmartGreen = Color(0xFF087F5B)
private val SmartDark = Color(0xFF102A2A)
private val SmartLightGreen = Color(0xFFE8F6F1)
private val SmartBackground = Color(0xFFF4F7F7)
private val SmartWhite = Color.White
private val SmartOrange = Color(0xFFFFA726)
private val SmartRed = Color(0xFFE53935)
private val SmartBlue = Color(0xFF1976D2)
private val SmartGrey = Color(0xFF6B7280)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                SmartBusApp()
            }
        }
    }
}

@Composable
fun SmartBusApp() {
    var screen by remember { mutableStateOf("welcome") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = SmartBackground
    ) {
        when (screen) {
            "welcome" -> WelcomeScreen {
                screen = "home"
            }

            "home" -> HomeScreen(
                onTracking = { screen = "tracking" },
                onArrivals = { screen = "arrivals" },
                onCrowd = { screen = "crowd" },
                onPooling = { screen = "pooling" },
                onAlerts = { screen = "alerts" }
            )

            "tracking" -> TrackingScreen {
                screen = "home"
            }

            "arrivals" -> ArrivalsScreen {
                screen = "home"
            }

            "crowd" -> CrowdScreen {
                screen = "home"
            }

            "pooling" -> PoolingScreen {
                screen = "home"
            }

            "alerts" -> AlertsScreen {
                screen = "home"
            }

            else -> WelcomeScreen {
                screen = "home"
            }
        }
    }
}

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SmartGreen)
            .padding(28.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(
                        SmartWhite,
                        RoundedCornerShape(30.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🚌", fontSize = 55.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "SmartBus",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = SmartWhite
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Smarter Routes.\nSmarter Stops.\nSmarter Travel.",
                fontSize = 17.sp,
                lineHeight = 25.sp,
                color = SmartWhite,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(38.dp))

            Button(
                onClick = onStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SmartWhite,
                    contentColor = SmartGreen
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "GET STARTED",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ScreenHeader(
    title: String,
    subtitle: String,
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .background(SmartWhite, RoundedCornerShape(12.dp))
                .clickable { onBack() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "←",
                fontSize = 27.sp,
                color = SmartDark
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = SmartDark
            )

            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = SmartGrey
            )
        }
    }
}

@Composable
fun HomeScreen(
    onTracking: () -> Unit,
    onArrivals: () -> Unit,
    onCrowd: () -> Unit,
    onPooling: () -> Unit,
    onAlerts: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(18.dp)
    ) {
        Text(
            text = "SmartBus",
            fontSize = 29.sp,
            fontWeight = FontWeight.Bold,
            color = SmartDark
        )

        Text(
            text = "Your daily travel companion",
            fontSize = 13.sp,
            color = SmartGrey
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = SmartGreen
            )
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "SERVICES ACTIVE",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = SmartWhite
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "12 buses currently operating",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = SmartWhite
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Demo service status",
                    fontSize = 12.sp,
                    color = SmartWhite
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = SmartWhite
            )
        ) {
            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "🚌", fontSize = 38.sp)

                Spacer(modifier = Modifier.width(14.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "NEXT BUS",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartGreen
                    )

                    Text(
                        text = "24A",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartDark
                    )

                    Text(
                        text = "Central → Airport",
                        fontSize = 12.sp,
                        color = SmartGrey
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "4 min",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartGreen
                    )

                    Text(
                        text = "ON TIME",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartGreen
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))
        SectionTitle("QUICK ACTIONS")
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickActionCard(
                emoji = "🗺️",
                title = "Buses",
                subtitle = "Bus tracking",
                modifier = Modifier.weight(1f),
                onClick = onTracking
            )

            QuickActionCard(
                emoji = "👥",
                title = "Smart Pool",
                subtitle = "Shared stops",
                modifier = Modifier.weight(1f),
                onClick = onPooling
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickActionCard(
                emoji = "🕒",
                title = "Arrivals",
                subtitle = "Bus timings",
                modifier = Modifier.weight(1f),
                onClick = onArrivals
            )

            QuickActionCard(
                emoji = "📊",
                title = "Crowd",
                subtitle = "Occupancy",
                modifier = Modifier.weight(1f),
                onClick = onCrowd
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        QuickActionCard(
            emoji = "🔔",
            title = "Smart Alerts",
            subtitle = "Delays and travel updates",
            modifier = Modifier.fillMaxWidth(),
            onClick = onAlerts
        )

        Spacer(modifier = Modifier.height(22.dp))
        SectionTitle("RECENT UPDATES")
        Spacer(modifier = Modifier.height(8.dp))

        UpdateCard(
            emoji = "🚌",
            title = "Bus 24A",
            message = "Estimated arrival in 4 minutes",
            status = "ON TIME",
            statusColor = SmartGreen
        )

        UpdateCard(
            emoji = "⚠️",
            title = "Bus 18B",
            message = "Running 2 minutes late",
            status = "DELAY",
            statusColor = SmartRed
        )

        UpdateCard(
            emoji = "👥",
            title = "Smart Pool",
            message = "A shared pickup stop is available",
            status = "READY",
            statusColor = SmartBlue
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = SmartLightGreen
            ),
            shape = RoundedCornerShape(18.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "💡", fontSize = 25.sp)

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "TRAVEL TIP",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartGreen
                    )

                    Text(
                        text = "Check your bus arrival time before leaving for the stop.",
                        fontSize = 12.sp,
                        color = SmartDark
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun QuickActionCard(
    emoji: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = SmartWhite
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = emoji, fontSize = 28.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = SmartDark
            )

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = SmartGrey
            )
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = SmartDark
    )
}

@Composable
fun UpdateCard(
    emoji: String,
    title: String,
    message: String,
    status: String,
    statusColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = SmartWhite
        )
    ) {
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = emoji, fontSize = 27.sp)

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = SmartDark
                )

                Text(
                    text = message,
                    fontSize = 12.sp,
                    color = SmartGrey
                )
            }

            Text(
                text = status,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = statusColor
            )
        }
    }
}

@Composable
fun TrackingScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ScreenHeader(
            title = "Live Bus Tracking",
            subtitle = "Buses currently operating",
            onBack = onBack
        )

        Column(modifier = Modifier.padding(horizontal = 18.dp)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SmartDark
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "🗺️", fontSize = 48.sp)

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "BUS ROUTE OVERVIEW",
                            fontWeight = FontWeight.Bold,
                            color = SmartWhite
                        )

                        Text(
                            text = "Sample bus locations",
                            fontSize = 12.sp,
                            color = SmartWhite
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            SectionTitle("BUSES NEARBY")

            BusTrackingCard(
                number = "24A",
                route = "Central → Airport",
                distance = "0.8 km",
                eta = "4 min",
                status = "ON TIME",
                statusColor = SmartGreen
            )

            BusTrackingCard(
                number = "18B",
                route = "Central → Railway",
                distance = "1.4 km",
                eta = "8 min",
                status = "2 MIN DELAY",
                statusColor = SmartRed
            )

            BusTrackingCard(
                number = "21C",
                route = "Market → City",
                distance = "2.1 km",
                eta = "13 min",
                status = "ON TIME",
                statusColor = SmartGreen
            )

            BusTrackingCard(
                number = "16A",
                route = "College → Central",
                distance = "3.2 km",
                eta = "18 min",
                status = "ON TIME",
                statusColor = SmartGreen
            )
        }
    }
}

@Composable
fun BusTrackingCard(
    number: String,
    route: String,
    distance: String,
    eta: String,
    status: String,
    statusColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = SmartWhite
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(SmartLightGreen, RoundedCornerShape(13.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "🚌",
                    fontSize = 25.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = number,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = SmartDark
                )

                Text(
                    text = route,
                    fontSize = 12.sp,
                    color = SmartGrey
                )

                Text(
                    text = distance,
                    fontSize = 11.sp,
                    color = SmartGrey
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = eta,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = SmartGreen
                )

                Text(
                    text = status,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = statusColor
                )
            }
        }
    }
}

@Composable
fun ArrivalsScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ScreenHeader(
            title = "Bus Arrivals",
            subtitle = "Upcoming bus timings",
            onBack = onBack
        )

        Column(modifier = Modifier.padding(horizontal = 18.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SmartLightGreen
                )
            ) {
                Row(
                    modifier = Modifier.padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "📍", fontSize = 32.sp)

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "NEAREST STOP",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = SmartGreen
                        )

                        Text(
                            text = "Central Bus Stop",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = SmartDark
                        )

                        Text(
                            text = "Sample arrival estimates",
                            fontSize = 12.sp,
                            color = SmartGrey
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            SectionTitle("UPCOMING ARRIVALS")

            ArrivalCard(
                bus = "24A",
                route = "Central → Airport",
                time = "4 min",
                status = "ON TIME",
                statusColor = SmartGreen
            )

            ArrivalCard(
                bus = "18B",
                route = "Central → Railway",
                time = "8 min",
                status = "2 MIN DELAY",
                statusColor = SmartRed
            )

            ArrivalCard(
                bus = "21C",
                route = "Market → City",
                time = "13 min",
                status = "ON TIME",
                statusColor = SmartGreen
            )

            ArrivalCard(
                bus = "16A",
                route = "College → Central",
                time = "18 min",
                status = "ON TIME",
                statusColor = SmartGreen
            )
        }
    }
}

@Composable
fun ArrivalCard(
    bus: String,
    route: String,
    time: String,
    status: String,
    statusColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = SmartWhite
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "🕒", fontSize = 27.sp)

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Bus $bus",
                    fontWeight = FontWeight.Bold,
                    color = SmartDark
                )

                Text(
                    text = route,
                    fontSize = 12.sp,
                    color = SmartGrey
                )

                Text(
                    text = status,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = statusColor
                )
            }

            Text(
                text = time,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = SmartGreen
            )
        }
    }
}

@Composable
fun CrowdScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ScreenHeader(
            title = "Crowd Status",
            subtitle = "Estimated bus occupancy",
            onBack = onBack
        )

        Column(modifier = Modifier.padding(horizontal = 18.dp)) {
            CrowdCard(
                bus = "24A",
                route = "Central → Airport",
                percentage = 32,
                status = "LOW",
                statusColor = SmartGreen
            )

            CrowdCard(
                bus = "18B",
                route = "Central → Railway",
                percentage = 89,
                status = "HIGH",
                statusColor = SmartRed
            )

            CrowdCard(
                bus = "21C",
                route = "Market → City",
                percentage = 57,
                status = "MODERATE",
                statusColor = SmartOrange
            )

            CrowdCard(
                bus = "16A",
                route = "College → Central",
                percentage = 44,
                status = "LOW",
                statusColor = SmartGreen
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Occupancy values are sample data for demonstration.",
                fontSize = 12.sp,
                color = SmartGrey
            )
        }
    }
}

@Composable
fun CrowdCard(
    bus: String,
    route: String,
    percentage: Int,
    status: String,
    statusColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = SmartWhite
        )
    ) {
        Column(modifier = Modifier.padding(17.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Bus $bus",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartDark
                    )

                    Text(
                        text = route,
                        fontSize = 12.sp,
                        color = SmartGrey
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "$percentage%",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = statusColor
                    )

                    Text(
                        text = status,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = statusColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(9.dp)
                    .background(
                        Color(0xFFE5E7EB),
                        RoundedCornerShape(10.dp)
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(percentage.coerceIn(0, 100) / 100f)
                        .height(9.dp)
                        .background(statusColor, RoundedCornerShape(10.dp))
                )
            }
        }
    }
}

@Composable
fun PoolingScreen(onBack: () -> Unit) {
    var joined by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ScreenHeader(
            title = "Smart Pool",
            subtitle = "Dynamic shared pickup stops",
            onBack = onBack
        )

        Column(modifier = Modifier.padding(horizontal = 18.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SmartGreen
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "👥", fontSize = 48.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "SHARED PICKUP STOP",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartWhite
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Central Community Stop",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartWhite,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Route 24A · Sample pooling information",
                        fontSize = 12.sp,
                        color = SmartWhite,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            SectionTitle("POOLING DETAILS")

            InfoCard(
                emoji = "📍",
                title = "Pickup location",
                description = "Central Community Stop"
            )

            InfoCard(
                emoji = "🚌",
                title = "Assigned bus",
                description = "24A · Central → Airport"
            )

            InfoCard(
                emoji = "👤",
                title = "Passengers grouped",
                description = "4 sample passenger requests"
            )

            InfoCard(
                emoji = "🕒",
                title = "Estimated pickup",
                description = "Approximately 4 minutes"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { joined = !joined },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (joined) SmartRed else SmartGreen
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = if (joined) {
                        "CANCEL DEMO REQUEST"
                    } else {
                        "JOIN SHARED PICKUP"
                    },
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = if (joined) {
                    "Demo request active. No real bus booking has been sent."
                } else {
                    "Join the sample shared pickup to see the interface response."
                },
                fontSize = 12.sp,
                color = SmartGrey,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun InfoCard(
    emoji: String,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = SmartWhite
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = emoji, fontSize = 27.sp)

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = SmartDark
                )

                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = SmartGrey
                )
            }
        }
    }
}

@Composable
fun AlertsScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ScreenHeader(
            title = "Smart Alerts",
            subtitle = "Travel notifications and updates",
            onBack = onBack
        )

        Column(modifier = Modifier.padding(horizontal = 18.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = SmartLightGreen
                )
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(text = "🔔", fontSize = 32.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Travel updates",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = SmartDark
                    )

                    Text(
                        text = "Sample notifications for your journey",
                        fontSize = 12.sp,
                        color = SmartGrey
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
            SectionTitle("RECENT ALERTS")

            UpdateCard(
                emoji = "✅",
                title = "Bus 24A on time",
                message = "Expected at Central Bus Stop in 4 minutes.",
                status = "INFO",
                statusColor = SmartGreen
            )

            UpdateCard(
                emoji = "⚠️",
                title = "Bus 18B delay",
                message = "The sample route is running 2 minutes late.",
                status = "DELAY",
                statusColor = SmartRed
            )

            UpdateCard(
                emoji = "👥",
                title = "Shared pickup available",
                message = "A sample Smart Pool stop is ready at Central.",
                status = "POOL",
                statusColor = SmartBlue
            )

            UpdateCard(
                emoji = "📍",
                title = "Arrival reminder",
                message = "Check your pickup point before travelling.",
                status = "REMINDER",
                statusColor = SmartOrange
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "These are demonstration notifications. Real push alerts require a notification service and backend integration.",
                fontSize = 12.sp,
                color = SmartGrey
            )
        }
    }
}
