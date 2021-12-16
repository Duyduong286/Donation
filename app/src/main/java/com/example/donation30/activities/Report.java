package com.example.donation30.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.donation30.R;
import com.example.donation30.models.Donation;

import java.util.List;

public class Report extends Base {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        listView = (ListView) findViewById(R.id.reportList);
        DonationAdapter adapter = new DonationAdapter(this, donations);
        listView.setAdapter(adapter);
    }

    class DonationAdapter extends ArrayAdapter<Donation>
    {
        private Context context;
        public List<Donation> donations;
        public DonationAdapter(Context context, List<Donation> donations)
        {
            super(context, R.layout.row_donate, donations);
            this.context = context;
            this.donations = donations;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.row_donate, parent, false);
            Donation donation = donations.get(position);
            TextView amountView = (TextView) view.findViewById(R.id.row_amount);
            TextView methodView = (TextView) view.findViewById(R.id.row_method);
            amountView.setText("$" + donation.amount);
            methodView.setText(donation.method);
            return view;
        }

        @Override
        public int getCount()
        {
            return donations.size();
        }
    }

}

