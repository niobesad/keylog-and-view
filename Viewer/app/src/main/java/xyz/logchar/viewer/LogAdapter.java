package xyz.logchar.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class LogAdapter extends FirebaseRecyclerAdapter<Log, LogAdapter.LogsViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options The options for the FirebaseRecyclerAdapter
     */
    public LogAdapter(@NonNull FirebaseRecyclerOptions<Log> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull LogsViewHolder holder, int position, @NonNull Log model) {
        holder.log.setText(model.getLog());
        holder.time.setText(model.getTime());
    }

    @NonNull
    @Override
    public LogsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.log, parent, false);
        return new LogsViewHolder(view);
    }

    static class LogsViewHolder extends RecyclerView.ViewHolder {
        TextView log, time;

        public LogsViewHolder(@NonNull View itemView) {
            super(itemView);
            log = itemView.findViewById(R.id.log);
            time = itemView.findViewById(R.id.textDate);
        }
    }
}
