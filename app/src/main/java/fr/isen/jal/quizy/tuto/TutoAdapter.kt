package fr.isen.jal.quizy.tuto

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TutoAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Tuto1Fragment()
            }
            1 -> {
                return Tuto2Fragment()
            }
            else -> {
                return Tuto1Fragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Questions Classiques"
            }
            1 -> {
                return "Emoji Quizz"
            }
        }
        return super.getPageTitle(position)
    }

}
