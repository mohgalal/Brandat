package com.example.brandat.ui.fragments.orderStatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brandat.R
import com.example.brandat.databinding.FirstOrderStatusBinding
import com.example.brandat.models.CustomerAddress
import com.example.brandat.ui.OrderStatus
import com.example.brandat.ui.fragments.address.AddressViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstOrderStatus : Fragment(), OnRadioClickListener {

    private var _binding: FirstOrderStatusBinding? = null
    private val binding get() = _binding!!
    lateinit var iChangeOrderStatus:IChangeOrderStatus
    private val viewModel: AddressViewModel by viewModels()
    private val mAdapter by lazy { AddressPaymentAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.first_order_status, container, false)

        iChangeOrderStatus = requireActivity() as OrderStatus

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showObservedData()

        binding.mapBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstOrderStatus_to_mapsFragment2)
        }
        binding.addAddressBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstOrderStatus_to_addAddressFragment2)
        }

        binding.animationView.setOnClickListener {
            findNavController().navigate(R.id.action_firstOrderStatus_to_addAddressFragment2)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstOrderStatus_to_secondOrderStatus)
            iChangeOrderStatus.changeStatus(1)
        }

    }

    private fun showObservedData() {
        viewModel.getAllAddress()
        viewModel.getAddresses.observe(viewLifecycleOwner) {
            initView(it)
        }

    }

    private fun initView(addresses: List<CustomerAddress>) {
        if (addresses.isNotEmpty()) {
            binding.animationView.visibility = View.GONE
            binding.txt.visibility = View.GONE
            binding.recyclerviewAddress.visibility = View.VISIBLE
            binding.fabMenu.visibility = View.VISIBLE
            mAdapter.setDatat(addresses)
            //addressAdapter = AddressAdapter(this)
            binding.recyclerviewAddress.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = mAdapter
            }

        }

    }

    override fun onItemClick(city: CustomerAddress) {
        Toast.makeText(context, "${city.printAddress()} ..selected", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}