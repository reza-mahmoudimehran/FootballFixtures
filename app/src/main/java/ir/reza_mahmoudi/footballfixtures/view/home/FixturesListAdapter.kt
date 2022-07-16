package ir.reza_mahmoudi.footballfixtures.view.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.reza_mahmoudi.footballfixtures.databinding.ItemLeagueBinding
import ir.reza_mahmoudi.footballfixtures.model.League

class FixturesListAdapter (private var leagues: ArrayList<League>) : RecyclerView.Adapter<FixturesListAdapter.FixturesViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun updateFixtures(newFixtures:List<League>){
        leagues.clear()
        leagues.addAll(newFixtures)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        val binding = ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FixturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        holder.bind(leagues[position])
    }

    override fun getItemCount(): Int =leagues.size

    class FixturesViewHolder(private val binding: ItemLeagueBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(league: League){
            binding.txtLeagueName.text=league.name
            val childMembersAdapter = MatchesListAdapter(league.matches)
            binding.rcvLeagueMatches.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL,false)
            binding.rcvLeagueMatches.adapter = childMembersAdapter
        }
    }
}