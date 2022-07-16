package ir.reza_mahmoudi.footballfixtures.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.reza_mahmoudi.footballfixtures.util.loadImage
import ir.reza_mahmoudi.footballfixtures.databinding.ItemMatchBinding
import ir.reza_mahmoudi.footballfixtures.model.Match
import ir.reza_mahmoudi.footballfixtures.util.getProgressDrawable

class MatchesListAdapter ( private val matches: List<Match>) : RecyclerView.Adapter<MatchesListAdapter.MatchesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val binding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int =matches.size

    class MatchesViewHolder(private val binding: ItemMatchBinding): RecyclerView.ViewHolder(binding.root){
        private val progressDrawable= getProgressDrawable(binding.root.context)

        fun bind(match: Match){
            binding.txtMatchHomeName.text=match.home.name
            binding.txtMatchHomeScore.text= match.home.score.toString()
            binding.txtMatchAwayName.text=match.away.name
            binding.txtMatchAwayScore.text=match.away.score.toString()
            binding.imgMatchHomeImage.loadImage(match.home.image,progressDrawable)
            binding.imgMatchAwayImage.loadImage(match.away.image,progressDrawable)
        }
    }
}