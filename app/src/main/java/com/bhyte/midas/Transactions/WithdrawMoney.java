package com.bhyte.midas.Transactions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bhyte.midas.AccountCreation.GetStarted;
import com.bhyte.midas.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WithdrawMoney extends AppCompatActivity {
    public static Double amountToWithdraw;
    public static String amountToWithdrawString;

    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;

    Context context;
    BottomSheetDialog bottomSheetDialog;
    Double userAmountDouble;
    MaterialButton withdrawButton;
    ImageView backspace, back;
    TextView amount, currentBalanceText, currency, one, two, three, four, five, six, seven, eight, nine, zero, dot;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_money);

        this.context = getApplicationContext();

        // Instance of FirebaseAuth and Database
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        // Hooks
        back = findViewById(R.id.back);
        amount = findViewById(R.id.amount);
        currency = findViewById(R.id.currency);
        currentBalanceText = findViewById(R.id.current_balance);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);

        backspace = findViewById(R.id.backspace);
        withdrawButton = findViewById(R.id.withdraw_button);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        assert firebaseUser != null;
        databaseReference.child(firebaseUser.getUid()).child("userMainBalance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String currentBalance = snapshot.getValue(String.class);
                assert currentBalance != null;
                currentBalanceText.setText("GH₵"+ currentBalance + " AVAILABLE");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Print an error message
                System.out.println("Error retrieving user main balance: " + error.getMessage());
            }
        });

        withdrawButton.setOnClickListener(v -> {
            // Get Input
            // Convert String to int
            String userInputAmount = amount.getText().toString();
            if (userInputAmount.equals("")) {
                // Custom Toast
                Toast toast = Toast.makeText(WithdrawMoney.this, R.string.right_amount, Toast.LENGTH_SHORT);
                View view1 = toast.getView();

                //Gets the actual oval background of the Toast then sets the colour filter
                view1.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.red), PorterDuff.Mode.SRC_IN);

                //Gets the TextView from the Toast so it can be edited
                TextView text = view1.findViewById(android.R.id.message);
                text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 15);
                toast.show();
            } else {
                userAmountDouble = Double.parseDouble(userInputAmount);
                amountToWithdraw = userAmountDouble;
                amountToWithdrawString = userInputAmount;

                if (userAmountDouble > 5000 | userAmountDouble < 20) {
                    Toast toast = Toast.makeText(WithdrawMoney.this, R.string.right_amount, Toast.LENGTH_SHORT);
                    View view1 = toast.getView();

                    //Gets the actual oval background of the Toast then sets the colour filter
                    view1.getBackground().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.red), PorterDuff.Mode.SRC_IN);

                    //Gets the TextView from the Toast so it can be edited
                    TextView text = view1.findViewById(android.R.id.message);
                    text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 15);
                    toast.show();
                } else {
                    // Check Input
                    startActivity(new Intent(context, AddMoneyChooseProvider.class));
                }
            }
        });

        // Click Listeners
        back.setOnClickListener(v -> finish());
        zero.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("0");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "0");
            }
        });
        one.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("1");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "1");
            }
        });
        two.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("2");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "2");
            }
        });
        three.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("3");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "3");
            }
        });
        four.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("4");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "4");
            }
        });
        five.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("5");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "5");
            }
        });
        six.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("6");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("7");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("8");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText("9");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + "9");
            }
        });
        dot.setOnClickListener(v -> {
            if (amount.getText().toString().equals("0")) {
                amount.setText(".");
            } else if (amount.getText().toString().length() == 7) {
                amount.setText(amount.getText().toString());
            } else {
                amount.setText(amount.getText().toString() + ".");
            }
        });
        backspace.setOnClickListener(v -> {
            if (amount.getText().toString().equals("") | amount.getText().toString().equals("0")) {
                amount.setText("0");
            } else {
                amount.setText(amount.getText().toString().substring(0, amount.getText().length() - 1));
            }
        });
    }
}