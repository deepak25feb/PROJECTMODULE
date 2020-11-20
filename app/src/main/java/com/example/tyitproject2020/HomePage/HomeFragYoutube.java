package com.example.tyitproject2020.HomePage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tyitproject2020.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragYoutube extends Fragment {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Model> list = new ArrayList<>();
    Context context;
    RecyclerView.LayoutManager manager;
    public HomeFragYoutube(Context context){
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getActivity().findViewById(R.id.recyclerview);
//        adapter = new Adapter(context,list);
//        manager = new LinearLayoutManager(context);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
        return inflater.inflate(R.layout.frag_live_utube, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        manager = new LinearLayoutManager(context);
        recyclerView = getActivity().findViewById(R.id.recyclerview);
        adapter = new Adapter(context,list);
        //manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        fetchdata();

    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        getActivity().findViewById(R.id.recyclerview);
//        adapter = new Adapter(context,list);
//        manager = new LinearLayoutManager(getActivity().getBaseContext());
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//        fetchdata();
//    }

    private void fetchdata(){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String link = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UCjEnh14bDYKXjO6I1I54McQ&maxResults=30&key=AIzaSyAjc9BmYpKwejVIK2N8xjViu-vmgkAnajM";
        //String link = "https://www.googleapis.com/youtube/v3/search?part=snippet&resultsPerPage=10&key=AIzaSyDlRiy6zK9ra0OYp0iGhh7t3DokRhdhaHs";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.optJSONArray("items");
                    for(int i = 0; i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        JSONObject jsonvideoid = jsonObject1.getJSONObject("id");
                        JSONObject jsonsnippet = jsonObject1.getJSONObject("snippet");
                        JSONObject jsonthumbnail = jsonsnippet.getJSONObject("thumbnails").getJSONObject("medium");
                        Model model = new Model();

                        if(i==0){}else {
                            model.setVideoId(jsonvideoid.getString("videoId"));
                            model.setTitle(jsonsnippet.getString("title"));
                            model.setUrl(jsonthumbnail.getString("url"));
                            list.add(model);
                        }


                        if(list.size() > 0 ){
                            adapter.notifyDataSetChanged();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "NO INTERNET", Toast.LENGTH_SHORT).show();
                //NO INTERNET FRAGMENT
                NoInternetInflator noInternet = new NoInternetInflator();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        noInternet).commit();
            }
        });

        requestQueue.add(stringRequest);   //main method id this for requesting

    }
}
