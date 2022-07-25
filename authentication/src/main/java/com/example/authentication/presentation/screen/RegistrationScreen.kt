import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.authentication.presentation.viewModel.AuthenticationViewModel
import com.example.design.UnifyButton
import com.example.design.UnifyEditText
import com.example.design.UnifyText

@Composable
fun RegistrationScreen(
    navigateTo : (String) -> Unit,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {
    Column( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        UnifyText(text = "Split Your Bills", fontSize = 36.sp)
        Spacer(modifier = Modifier.height(10.dp))
        UnifyText(text = "Registration", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(30.dp))
        UnifyEditText(headerText = "Name")
        Spacer(modifier = Modifier.height(20.dp))
        UnifyEditText(headerText = "Phone No.")
        Spacer(modifier = Modifier.height(20.dp))
        UnifyEditText(headerText = "Password")
        Spacer(modifier = Modifier.height(50.dp))
        UnifyButton(buttonText = "Register", {

        })
    }
}