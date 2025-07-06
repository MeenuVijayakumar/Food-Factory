package com.applab.foodfactory.ui.monthly_dashboard.overview

import com.applab.shared.monthlydashboard.model.CellMonthlyDashboardItem
import com.applab.shared.monthlydashboard.model.MonthlyDashboardCellState
import kotlinx.coroutines.flow.Flow

data class EventCellDefinition(
    override var title: String? = "Events",
    override var cellTypeIdentifier: String? = CELL_TYPE_IDENTIFIER_EVENTS,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState,
    override var viewType: Int = VIEW_TYPE_EVENTS
) : CellMonthlyDashboardItem

data class MarketingCampaignCellDefinition(
    override var title:String? ="Marketing campaign impressions\n(Mn)",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_CAMPAIGN_IMPRESSION,
    override var viewType: Int = VIEW_TYPE_CAMPAIGN_IMPRESSION,
    override val resolver: ((/*httpClient: OkHttpClient, */cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class MediaReachCellDefinition(
    override var title: String?="Media reach\n(Mn)",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_MEDIA_REACH,
    override var viewType: Int = VIEW_TYPE_MEDIA_REACH,
    override val resolver: ((/*httpClient: OkHttpClient, */cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class ActiveLeadsCellDefinition(
    override var title: String?="Active leads",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_ACTIVE_LEADS,
    override var viewType: Int = VIEW_TYPE_ACTIVE_LEADS,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class InvestorMeetingsCellDefinition(
    override var title: String?="Investor meetings",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_INVESTOR_MEETINGS,
    override var viewType: Int = VIEW_TYPE_INVESTOR_MEETING,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class StakeholderMeetingsCellDefinition(
    override var title: String?="Stakeholder meetings",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_STAKE_HOLDER_MEETINGS,
    override var viewType: Int = VIEW_TYPE_STAKE_HOLDER_MEETINGS,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class ResearchPublicationsCellDefinition(
    override var title: String?="Research publications",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_RESEARCH_PUBLICATIONS,
    override var viewType: Int = VIEW_TYPE_RESEARCH_PUBLICATION,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class ResearchAnalysisCellDefinition(
    override var title: String?="Research analysis",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_RESEARCH_ANALYSIS,
    override var viewType: Int = VIEW_TYPE_RESEARCH_ANALYSIS,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class PolicyAdvocacyStudiesCellDefinition(
    override var title: String?="Policy advocacy studies",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_POLICY_ADVOCACY_STUDIES,
    override var viewType: Int = VIEW_TYPE_POLICY_ADVOCACY_STUDIES,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class BudgetUtilizedCellDefinition(
    override var title: String?="Budget utilized\n(QAR Mn)",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_BUDGET_UTILIZED,
    override var viewType: Int = VIEW_TYPE_BUDGET_UTILIZED,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem

data class FTECumulativeCellDefinition(
    override var title: String?="Full-time employees\n(cumulative)",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_FULL_TIME_EMP,
    override var viewType: Int = VIEW_TYPE_FULL_TIME_EMP,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem
data class LearningDevelopmentCellDefinition(
    override var title: String?="Learning & development sessions",
    override var cellTypeIdentifier: String?= CELL_TYPE_IDENTIFIER_LEARNING_DEVELOPMENT,
    override var viewType: Int = VIEW_TYPE_LEARNING_DEVELOPMENT,
    override val resolver: ((/*httpClient: OkHttpClient,*/ cellDate: CellMonthlyDashboardItem, params: Map<String, String>?) -> Flow<MonthlyDashboardCellState>)?,
    override var cellState: MonthlyDashboardCellState
):CellMonthlyDashboardItem
