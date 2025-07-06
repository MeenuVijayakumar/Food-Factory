package com.applab.foodfactory.ui.monthly_dashboard.model

import com.applab.foodfactory.ui.monthly_dashboard.overview.ActiveLeadsCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.BudgetUtilizedCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.EventCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.FTECumulativeCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.InvestorMeetingsCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.LearningDevelopmentCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.MarketingCampaignCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.MediaReachCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.PolicyAdvocacyStudiesCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.ResearchAnalysisCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.ResearchPublicationsCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.overview.StakeholderMeetingsCellDefinition
import com.applab.foodfactory.ui.monthly_dashboard.reslover.resolveAfdi
import com.applab.shared.monthlydashboard.model.Idle


val monthlyDashboardCellDefinitions = listOf(
    EventCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    MarketingCampaignCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    MediaReachCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    ActiveLeadsCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    InvestorMeetingsCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    StakeholderMeetingsCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    ResearchPublicationsCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    ResearchAnalysisCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    PolicyAdvocacyStudiesCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    BudgetUtilizedCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    FTECumulativeCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    ),
    LearningDevelopmentCellDefinition(
        cellState = Idle,
        resolver = ::resolveAfdi
    )
)